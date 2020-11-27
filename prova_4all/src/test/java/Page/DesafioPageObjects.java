package Page;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DesafioPageObjects
{
    static ExtentTest logger ;
    static ExtentReports report;

    public static void InicioTeste(){
        report = new ExtentReports("G:\\Dev\\Java\\Relatorios\\"+"RelatorioExtent.html",true);
        Base.AbrirNavegador("chrome");
        logger = report.startTest("Desafio01");
    }

    public static void FinalTeste(){
        report.flush();
        report.endTest(logger);
        Base.FecharNavegador();
    }

    public void Screenshot() throws IOException {
        java.util.Date data = new Date();
        File screenshot =((TakesScreenshot)Base.navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("G:\\Dev\\Java\\Relatorios\\Screenshot.png"));
    }

    public By btnCategorias = By.id("open-categories-btn");
    public By btnCategoriasTodos = By.id("category-all");
    public By btnCategoriasBebida = By.id("category-0");
    public By btnCategoriasDoces = By.id("category-1");
    public By btnCategoriasSalgados = By.id("category-2");
    public By btnCategoriasPratos = By.id("category-3");
    public By btnAddProdutoCoca = By.id("add-product-0-btn");
    public By btnAddProdutoFanta = By.id("add-product-1-btn");
    public By btnAddProdutoAgua = By.id("add-product-2-btn");
    public By btnAddProdutoRissole = By.id("add-product-3-btn");
    public By btnAddProdutoBrigadeiro = By.id("add-product-4-btn");
    public By btnAddProdutoAlfajor = By.id("add-product-5-btn");
    public By btnCarrinho = By.id("cart-products-qtd");
    public By btnTelaInicial = By.id("back-button");
    public By btnAumentarQtdeCoca = By.id("add-product-0-qtd");
    public By btnDiminuirQtdeCoca = By.id("remove-product-0-qtd");
    public By btnAumentarQtdeFanta = By.id("add-product-1-qtd");
    public By btnDiminuirQtdeFanta = By.id("remove-product-1-qtd");
    public By btnAumentarQtdeAgua = By.id("add-product-2-qtd");
    public By btnDiminuirQtdeAgua = By.id("remove-product-2-qtd");
    public By btnAumentarQtdeRissole = By.id("add-product-3-qtd");
    public By btnDiminuirQtdeRissole = By.id("remove-product-3-qtd");
    public By btnAumentarQtdeBrigadeiro = By.id("add-product-4-qtd");
    public By btnDiminuirQtdeBrigadeiro = By.id("remove-product-4-qtd");
    public By btnAumentarQtdeAlfajor = By.id("add-product-5-qtd");
    public By btnDiminuirQtdeAlfajor = By.id("remove-product-5-qtd");
    public By lblValor = By.id("price-total-checkout");
    public By lblPedidoRealizado = By.cssSelector("h2.sc-dNLxif.jyncPa");
    public By btnFinalizarCompra = By.id("finish-checkout-button");
    public By btnFechar = By.cssSelector("button.close-modal.sc-jqCOkK.ippulb");


    public void AdicionarTodosProdutos()
    {
        List<WebElement> listaProduto = Base.navegador.findElements(By.xpath("//div[2]/button"));
        for (WebElement produto : listaProduto) {
            produto.click();
        }
        logger.log(LogStatus.INFO,"Todos os Produtos adicionados");
    }

    public void MudarQuantidadeProduto(By locator, int qtde)
    {
        for(int i = 1; i <= qtde; ++i){
            Base.Click(locator);
            logger.log(LogStatus.INFO,"Quantidade alterada ");
        }
    }

    public boolean ValidaValor(String valorEsperado){
        WebElement labelValor=  Base.navegador.findElement(By.id("price-total-checkout"));
        String valorAtual=labelValor.getText();
        try{
            Assert.assertEquals(valorEsperado,valorAtual);
            logger.log(LogStatus.INFO,valorAtual+" Valor OK");
            logger.log(LogStatus.PASS,"validaçao passou");
            Screenshot();
            return true;
        }
        catch (Exception f){
            logger.log(LogStatus.INFO,valorAtual+" Valor errado");
            return false;
        }
    }

    public boolean ValidaTexto(String texto){

        WebElement labelTexto = Base.navegador.findElement(By.cssSelector("h2.sc-dNLxif.jyncPa"));
        String labelAtual = labelTexto.getText();
        try{
            Assert.assertEquals(texto,labelAtual);
            logger.log(LogStatus.INFO,labelAtual+" Texto OK");
            logger.log(LogStatus.PASS,"validaçao passou");
            Screenshot();
            return true;
        }
        catch (Exception f){
            logger.log(LogStatus.INFO,labelAtual+" Texto errado");
            return false;
        }
    }
}
