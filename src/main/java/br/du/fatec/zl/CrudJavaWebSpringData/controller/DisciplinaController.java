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
import br.du.fatec.zl.CrudJavaWebSpringData.service.IDisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	IDisciplinaService disciplinaService;

	@RequestMapping(name = "disciplina", value = "/disciplina", method = RequestMethod.GET)
	public ModelAndView disciplinaGet(ModelMap model) {
		return new ModelAndView("disciplina");
	}

	@RequestMapping(name = "disciplina", value = "/disciplina", method = RequestMethod.POST)
	public ModelAndView disciplinaPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Disciplina di = new Disciplina();
		List<Disciplina> disciplinas = new ArrayList<>();

		try {
			if (cmd.contains("Listar")) {
				disciplinas = listarDisciplina();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("disciplina", di);
			model.addAttribute("disciplinas", disciplinas);

		}

		return new ModelAndView("disciplina");
	}

	private List<Disciplina> listarDisciplina() throws SQLException, ClassNotFoundException {
		return disciplinaService.getAllDisciplinas();
	}
}
