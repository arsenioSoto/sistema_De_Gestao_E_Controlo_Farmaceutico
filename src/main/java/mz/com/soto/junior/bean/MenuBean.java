package mz.com.soto.junior.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import mz.com.soto.junior.converter.MenuDAO;
import mz.com.soto.junior.domain.Menu;


@ManagedBean
@SessionScoped
public class MenuBean {
	private MenuModel modeloDoMenu;
	
	public MenuModel getModeloDoMenu() {
		return modeloDoMenu;
	}
	
	public void setModeloDoMenu(MenuModel modeloDoMenu) {
		this.modeloDoMenu = modeloDoMenu;
	
	}
}
