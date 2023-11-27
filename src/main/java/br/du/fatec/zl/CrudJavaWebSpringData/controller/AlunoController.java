package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Aluno;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IAlunoService;

@Controller
public class AlunoController {

	@Autowired
	IAlunoService alunoService;

	@RequestMapping(name = "aluno", value = "/aluno", method = RequestMethod.GET)
	public ModelAndView alunoGet(ModelMap model) {
		return new ModelAndView("aluno");
	}

	@RequestMapping(name = "aluno", value = "/aluno", method = RequestMethod.POST)
	public ModelAndView alunoPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");
		String ra = allRequestParam.get("RA");
		String cursoCodigo = allRequestParam.get("cursoCodigo");
		String turno = allRequestParam.get("turno");
		String cpf = allRequestParam.get("CPF");
		String nome = allRequestParam.get("nome");
		String nomeSocial = allRequestParam.get("nomeSocial");
		String dataNascimento = allRequestParam.get("dataNascimento");
		String tel = allRequestParam.get("tel");
		String emailPes = allRequestParam.get("emailPes");
		String emailCor = allRequestParam.get("emailCor");
		String dataConclusaoSeg = allRequestParam.get("dataConclusaoSeg");
		String instituicaoConclusaoSeg = allRequestParam.get("instituicaoConclusaoSeg");
		String pontuacaoVestibular = allRequestParam.get("pontuacaoVestibular");
		String posicaoVestibular = allRequestParam.get("posicaoVestibular");
		String dataIngresso = allRequestParam.get("dataIngresso");
		String semestreAnoIngresso = allRequestParam.get("semestreAnoIngresso");
		String semestreAnoLimiteGrad = allRequestParam.get("semestreAnoLimiteGrad");

		// retorno
		String saida = "";
		String erro = "";
		Aluno al = new Aluno();
		List<Aluno> alunos = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			al.setRA(Integer.parseInt(ra));
		}
		if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {

			LocalDate data_nasc = (LocalDate.parse(dataNascimento));
			LocalDate data_con = (LocalDate.parse(dataConclusaoSeg));
			LocalDate data_ing = (LocalDate.parse(dataIngresso));

			al.setRA(Integer.parseInt(ra));
			al.setCursoCodigo(Integer.parseInt(cursoCodigo));
			al.setTurno(turno);
			al.setCPF(cpf);
			al.setNome(nome);
			al.setNomeSocial(nomeSocial);
			al.setDataNascimento(data_nasc);
			al.setTel(Integer.parseInt(tel));
			al.setEmailPes(emailPes);
			al.setEmailCor(emailCor);
			al.setDataConclusaoSeg(data_con);
			al.setInstituicaoConclusaoSeg(instituicaoConclusaoSeg);
			al.setPontuacaoVestibular(Float.parseFloat(pontuacaoVestibular));
			al.setPosicaoVestibular(Integer.parseInt(posicaoVestibular));
			al.setDataIngresso(data_ing);
			al.setSemestreAnoIngresso(semestreAnoIngresso);
			al.setSemestreAnoLimiteGrad(semestreAnoLimiteGrad);

		}

		try {
			if (cmd.contains("Cadastrar")) {
				cadastrarAluno(al);
				al = null;
			}
			if (cmd.contains("Alterar")) {
				alterarAluno(al);
				al = null;
			}
			if (cmd.contains("Excluir")) {
				excluirAluno(Integer.parseInt(ra));
				al = null;
			}
			if (cmd.contains("Buscar")) {
				al = buscarAluno(Integer.parseInt(ra));
			}
			if (cmd.contains("Listar")) {
				alunos = listarAluno();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("aluno", al);
			model.addAttribute("alunos", alunos);
		}

		return new ModelAndView("aluno");
	}

	private void cadastrarAluno(Aluno al) throws SQLException, ClassNotFoundException {
		alunoService.saveAluno(al);

	}

	private void alterarAluno(Aluno al) throws SQLException, ClassNotFoundException {
		alunoService.saveAluno(al);
	}

	private void excluirAluno(int ra) throws SQLException, ClassNotFoundException {
		alunoService.deleteAluno(ra);
	}

	private Aluno buscarAluno(int ra) throws SQLException, ClassNotFoundException {
		return alunoService.getAlunoById(ra);
	}

	private List<Aluno> listarAluno() throws SQLException, ClassNotFoundException {
		return alunoService.getAllAlunos();
	}
}
