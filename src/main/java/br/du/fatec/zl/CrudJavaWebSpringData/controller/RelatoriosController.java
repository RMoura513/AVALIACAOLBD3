package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
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

import br.du.fatec.zl.CrudJavaWebSpringData.model.Historico;
import br.du.fatec.zl.CrudJavaWebSpringData.model.Relatorio;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IRelatoriosService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class RelatoriosController {

	@Autowired
	IRelatoriosService relatoriosService;
	
	@Autowired
    private DataSource dataSource;

	@RequestMapping(name = "relatorio", value = "/relatorio", method = RequestMethod.GET)
	public ModelAndView relatorioGet(ModelMap model) {
		return new ModelAndView("relatorio");
	}

	@RequestMapping(name = "relatorio", value = "/relatorio", method = RequestMethod.POST)
	public ModelAndView relatorioPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Relatorio r = new Relatorio();
		List<Relatorio> relatorios = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			//r.setAlunoRA(alunoRA);
		}
		try {
			if (cmd.contains("Listar")) {
				relatorios = listarRelatorios();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("relatorio", r);
			model.addAttribute("relatorios", relatorios);
		}
		return new ModelAndView("relatorio");
	}
	
	@RequestMapping(name = "relatorioPdf", value = "/relatorioPdf", method = RequestMethod.POST)
	public ResponseEntity relatorioPdfPost(@RequestParam Map<String, String> allRequestParam) throws SQLException {
		String erro = "";
		Map<String, Object> paramRelatorio = new HashMap<String, Object>();
	//	paramRelatorio.put("", paramRelatorio);
	
		byte[] bytes = null;
		
		InputStreamResource resource = null;
		HttpStatus status = null;
		HttpHeaders header = new HttpHeaders();
		
		try (Connection connection = dataSource.getConnection()){
			File arquivo = ResourceUtils.getFile("classpath:reports/AusenciaRelatorio.jasper");
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
	
	

	private List<Relatorio> listarRelatorios() throws SQLException, ClassNotFoundException {
		return relatoriosService.getAllRelatorios();
	}

}
