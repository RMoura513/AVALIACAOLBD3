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

import br.du.fatec.zl.CrudJavaWebSpringData.model.Conteudo;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IConteudoService;

@Controller
public class ConteudoController {

	@Autowired
	IConteudoService conteudoService;

	@RequestMapping(name = "conteudo", value = "/conteudo", method = RequestMethod.GET)
	public ModelAndView conteudoGet(ModelMap model) {
		return new ModelAndView("conteudo");
	}

	@RequestMapping(name = "conteudo", value = "/conteudo", method = RequestMethod.POST)
	public ModelAndView conteudoPost(@RequestParam Map<String, String> allRequestParam, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Conteudo co = new Conteudo();
		List<Conteudo> conteudos = new ArrayList<>();

		try {
			if (cmd.contains("Listar")) {
				conteudos = listarConteudo();
			}

		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("conteudo", co);
			model.addAttribute("conteudos", conteudos);

		}

		return new ModelAndView("conteudo");

	}

	private List<Conteudo> listarConteudo() throws SQLException, ClassNotFoundException {
		return conteudoService.getAllConteudos();
	}
}
