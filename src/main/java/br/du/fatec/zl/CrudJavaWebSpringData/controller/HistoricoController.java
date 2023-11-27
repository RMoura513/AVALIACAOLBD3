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

import br.du.fatec.zl.CrudJavaWebSpringData.model.Historico;
import br.du.fatec.zl.CrudJavaWebSpringData.service.IHistoricoService;

@Controller
public class HistoricoController {

	@Autowired
	IHistoricoService historicoService;

	@RequestMapping(name = "historico", value = "/historico", method = RequestMethod.GET)
	public ModelAndView historicoGet(ModelMap model) {
		return new ModelAndView("historico");
	}

	@RequestMapping(name = "historico", value = "/historico", method = RequestMethod.POST)
	public ModelAndView historicoPost(@RequestParam Map<String, String> allRequestParam, int alunoRA, ModelMap model) {

		// entrada
		String cmd = allRequestParam.get("botao");

		// retorno
		String saida = "";
		String erro = "";
		Historico h = new Historico();
		List<Historico> historicos = new ArrayList<>();
		List<Historico> historicos2 = new ArrayList<>();

		if (!cmd.contains("Listar")) {
			h.setAlunoRA(alunoRA);
		}
		try {
			if (cmd.contains("Listar")) {
				historicos = listarHistoricos(alunoRA);
				historicos2 = listarHistoricos2(alunoRA);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("historico", h);
			model.addAttribute("historicos", historicos);
			model.addAttribute("historicos2", historicos2);
		}
		return new ModelAndView("historico");
	}

	private List<Historico> listarHistoricos(int alunoRA) throws SQLException, ClassNotFoundException {
		return historicoService.getAllHistorico1(alunoRA);
	}

	private List<Historico> listarHistoricos2(int alunoRA) throws SQLException, ClassNotFoundException {
		return historicoService.getAllHistorico2(alunoRA);
	}
}
