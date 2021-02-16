package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.framework.managers.ManagerPages;

public class Steps {
    
	/**
     * Менеджер страничек
     */
    private ManagerPages app = ManagerPages.getManagerPages();
    
    @Когда("^Загружена стартовая страница$")
    public void initPage(){
        app.getStartPage();
    }

    @Когда("^Переход в главное меню '(.*)'$")
    public void selectBaseMenu(String nameBaseMenu) {
    	app.getStartPage().selectBaseMenu(nameBaseMenu);
    }
    
    @Когда("^Выбираем подменю '(.*)'$")
    public void selectSubMenu(String nameSubMenu) {
    	app.getStartPage().selectSubMenu(nameSubMenu);
    }
    
    @Когда("^Переходим в Iframe$")
    public void swithTo() {
    	app.getCreditCalculator().switchToData();
    }
    
    
    @Когда("^Заполняем форму поле/значение$")
    public void filling(DataTable dataTable) {
    	dataTable.cells().forEach(
    			raw ->{
    				app.getCreditCalculator().filling(raw.get(0), raw.get(1));
    			});
    }
    
    @Когда("^Выбираем дополнительные опции$")
    public void optionalServices(DataTable dataTable) {
    	dataTable.cells().forEach(
    			raw ->{
    				app.getCreditCalculator().optionalServices(raw.get(0));
    			});
    }
    
    @Тогда("^Проверяем поля и их значения$")
    public void checkFinalSum(DataTable dataTable) {
    	dataTable.cells().forEach(
    			raw ->{
    				app.getCreditCalculator().checkFinalSum(raw.get(0), raw.get(1));
    			});
    }
}
