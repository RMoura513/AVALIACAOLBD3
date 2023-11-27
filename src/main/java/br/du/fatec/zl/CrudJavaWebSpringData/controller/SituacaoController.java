package br.du.fatec.zl.CrudJavaWebSpringData.controller;

import java.sql.SQLException;
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

import br.du.fatec.zl.CrudJavaWebSpringData.model.Disciplina;
import br.du.fatec.zl.CrudJavaWebSpringData.model.Matricula;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IDisciplinaService;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IMatriculaService;
import br.du.fatec.zl.CrudJavaWebSpringData.service.ISituacaoService;

@Controller
public class SituacaoController {

	@Autowired
	IMatriculaService matriculaService;

	@Autowired
	IDisciplinaService disciplinaService;

	@Autowired
	ISituacaoService situacaoService;

	@RequestMapping(name = "situacao", value = "/situacao", method = RequestMethod.GET)
	public ModelAndView situacaoGet(ModelMap model) {
		String erro = "";
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();

		try {
			disciplinas = disciplinaService.getAllDisciplinas();
		} finally {
			model.addAttribute("erro", erro);
			model.addAttribute("disciplinas", disciplinas);

		}
		return new ModelAndView("situacao");

	}

	@RequestMapping(name = "situacao", value = "/situacao", method = RequestMethod.POST)
	public ModelAndView situacaoPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {
		// entrada
		String cmd = allRequestParam.get("botao");
		String alunoRA = allRequestParam.get("alunoRA");
		String disciplinaCodigo = allRequestParam.get("disciplinaCodigo");
		String situacao = allRequestParam.get("situacao");
		String diaSemana = allRequestParam.get("diaSemana");

		// retorno
		String saida = "";
		String erro = "";
		Matricula ma = new Matricula();
		List<Matricula> matriculas = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			ma.setAlunoRA(Integer.parseInt(alunoRA));
		}
		try {

			if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
				ma.setAlunoRA(Integer.parseInt(alunoRA));
				ma.setDisciplinaCodigo(Integer.parseInt(disciplinaCodigo));
				ma.setSituacao(situacao);
				ma.setDiaSemana(diaSemana);

			}

			if (cmd.contains("Cadastrar")) {
				cadastrarMatricula(ma);
				ma = null;
			}

			if (cmd.contains("Listar")) {
				int alunoRAFiltrar = -1;
				if (alunoRA != null && !alunoRA.isEmpty()) {
					alunoRAFiltrar = Integer.parseInt(alunoRA);
				}
				matriculas = listarMatricula(alunoRAFiltrar);
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("matricula", ma);
			model.addAttribute("matriculas", matriculas);

		}

		return new ModelAndView("situacao");

	}

	private void cadastrarMatricula(Matricula ma) throws SQLException, ClassNotFoundException {
		matriculaService.iudMatricula(ma);
	}

	private List<Matricula> listarMatricula(int alunoRA) throws SQLException, ClassNotFoundException {
		return matriculaService.getAllMatriculas(alunoRA);
	}

}
