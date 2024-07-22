package com.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventory.repositories.vo.BookInventoryVo;
import com.inventory.repositories.vo.UserVo;
import com.inventory.services.BookInventoryService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/branch")
@Controller
public class BranchController {
	
	@Autowired
	private BookInventoryService bookInvenService;
	
	@RequestMapping({"/inventory", "/home"})
	public String branchHome(HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value="check", required = false) String check,
			@RequestParam(value = "orderBy", defaultValue = "kindcode desc, book_name asc") String orderBy,
			Model model) {
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		Map <String, Object> params = new HashMap<>();
		params.put("branchId", authUser.getBranchId());
	    params.put("keyword", keyword != null ? keyword : "");
	    params.put("check", check);
	    params.put("orderBy", orderBy != null ? orderBy.trim() : null);

		model.addAttribute("list", bookInvenService.invenList(params));
		
//		session.setAttribute("authUser", authUser);
		
		return "branches/branch_home";
	}
	
	@RequestMapping("/thenewneodynamicinventory")
	public String newHome() {
		return"branches/branch_home_ajax";
	}
	
	@RequestMapping(value = "/initialList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List <BookInventoryVo> getInitialList(HttpSession session){
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		Map <String, Object> params = new HashMap<>();
		params.put("branchId", userVo.getBranchId());
	    params.put("keyword", "");
	    params.put("check", "");
	    params.put("orderBy", "kindcode desc, book_name asc");
		return bookInvenService.invenList(params);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<BookInventoryVo> search(HttpSession session, @RequestParam("keyword") String keyword,
    		@RequestParam(value="check", required = false) String check,
    		@RequestParam(value = "orderBy", defaultValue = "kindcode desc, book_name asc") String orderBy,
    		@RequestParam(value = "startDate", required = false) String startDate,
    		@RequestParam(value = "endDate", required = false) String endDate) {
        UserVo vo = (UserVo) session.getAttribute("authUser");
        
        Map <String, Object> params = new HashMap<>();
		params.put("branchId", vo.getBranchId());
	    params.put("keyword", keyword != null ? keyword : "");
	    params.put("check", check);
	    params.put("orderBy", orderBy != null ? orderBy.trim() : null);
	    params.put("startDate", startDate);
	    params.put("endDate", endDate);
        
        return bookInvenService.invenList(params);
    }
}
