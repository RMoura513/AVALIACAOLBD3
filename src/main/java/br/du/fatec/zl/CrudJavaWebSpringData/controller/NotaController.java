package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Aluno;
import br.du.fatec.zl.CrudJavaWebSpringData.model.Nota;
import br.du.fatec.zl.CrudJavaWebSpringData.service.INotaService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class NotaController {

	@Autowired
	INotaService notaService;
	
	@Autowired
    private DataSource dataSource;

	@RequestMapping(name = "nota", value = "/nota", method = RequestMethod.GET)
	public ModelAndView notaGet(ModelMap model) {

		return new ModelAndView("nota");
	}

	@RequestMapping(name = "nota", value = "/nota", method = RequestMethod.POST)
	public ModelAndView notaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		
		// entrada
		String cmd = allRequestParam.get("botao");
		String codigo = allRequestParam.get("codigo");
		String alunoRA = allRequestParam.get("alunoRA");
		String avaliacaoCodigo = allRequestParam.get("avaliacaoCodigo");
		String disciplinaCodigo = allRequestParam.get("disciplinaCodigo");
		String notaP1 = allRequestParam.get("notaP1");
		String notaP2 = allRequestParam.get("notaP2");
		String notaP3 = allRequestParam.get("notaP3");
		String notaT = allRequestParam.get("notaT");
		String notaA = allRequestParam.get("notaA");
		String notaM = allRequestParam.get("notaM");
		
		// retorno
		String saida = "";
		String erro = "";
		Nota no = new Nota();
		List<Nota> notas = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			no.setAlunoRA(Integer.parseInt(alunoRA));
		}
		if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {

		//	no.setCodigo(Integer.parseInt(codigo));
			no.setAlunoRA(Integer.parseInt(alunoRA));
		//	no.setAvaliacaoCodigo(Integer.parseInt(avaliacaoCodigo));
			no.setDisciplinaCodigo(Integer.parseInt(disciplinaCodigo));
			no.setNotaP1(Float.parseFloat(notaP1));
			no.setNotaP2(Float.parseFloat(notaP2));
			no.setNotaP3(Float.parseFloat(notaP3));
			no.setNotaT(Float.parseFloat(notaT));
			no.setNotaA(Float.parseFloat(notaA));
			no.setNotaM(Float.parseFloat(notaM));

		}

		try {
			if (cmd.contains("Cadastrar")) {
				cadastrarNota(no);
				no = null;
			}
			if (cmd.contains("Alterar")) {
				alterarNota(no);
				no = null;
			}
			/*
			 * if (cmd.contains("Excluir")) { excluirAluno(Integer.parseInt(ra)); al = null;
			 * } if (cmd.contains("Buscar")) { al = buscarAluno(Integer.parseInt(ra)); }
			 */
			if (cmd.contains("Listar")) {
				notas = listarNota();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("nota", no);
			model.addAttribute("notas", notas);
		}

		return new ModelAndView("nota");
	}
	
	@RequestMapping(name = "notaPdf", value = "/notaPdf", method = RequestMethod.POST)
	public ResponseEntity relatorioPdfPost(@RequestParam Map<String, String> allRequestParam) throws SQLException {
		String erro = "";
		Map<String, Object> paramRelatorio = new HashMap<String, Object>();
	//	paramRelatorio.put("", paramRelatorio);
	
		byte[] bytes = null;
		
		InputStreamResource resource = null;
		HttpStatus status = null;
		HttpHeaders header = new HttpHeaders();
		
		try (Connection connection = dataSource.getConnection()){
			File arquivo = ResourceUtils.getFile("classpath:reports/NotaRelatorio.jasper");
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(arquivo.getAbsolutePath());
			bytes = JasperRunManager.runReportToPdf(report, paramRelatorio, connection);
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			erro = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}finally {
			if (erro.equals("")) {
				ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
				resource = new InputStreamResource(inputStream);
				header.setContentLength(bytes.length);
				header.setContentType(MediaType.APPLICATION_PDF);
				status = HttpStatus.OK;
			}
		}
		
		return new ResponseEntity(resource, header, status);		
		
	}
	

	private void cadastrarNota(Nota no) throws SQLException, ClassNotFoundException {
		notaService.saveNota(no);

	}
	private void alterarNota(Nota no) throws SQLException, ClassNotFoundException {
		notaService.saveNota(no);
	}

	/*
	 * private void excluirAluno(int ra) throws SQLException, ClassNotFoundException
	 * { alunoService.deleteAluno(ra); }
	 * 
	 * private Aluno buscarAluno(int ra) throws SQLException, ClassNotFoundException
	 * { return alunoService.getAlunoById(ra); }
	 */

	private List<Nota> listarNota() throws SQLException, ClassNotFoundException {
		return notaService.getAllNotas();
	}

}
