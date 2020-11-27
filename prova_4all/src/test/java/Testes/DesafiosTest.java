package Testes;

import Page.Base;
import Page.DesafioPageObjects;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DesafiosTest  {

    @BeforeTest
    public void Antes(){
        desafio.InicioTeste();
    }

    @AfterTest
    public void Depois(){
        desafio.FinalTeste();
    }

    DesafioPageObjects desafio = new DesafioPageObjects();

    @Test
    public void testDesafio01()
    {
        Base.Click(desafio.btnCategorias);
        Base.Click(desafio.btnCategoriasDoces);
        desafio.AdicionarTodosProdutos();
        Base.Click(desafio.btnCategorias);
        Base.Click(desafio.btnCategoriasTodos);
        Base.Click(desafio.btnCarrinho);
        desafio.MudarQuantidadeProduto(desafio.btnAumentarQtdeBrigadeiro,4);
        Base.Click(desafio.btnFinalizarCompra);
        Assert.assertTrue(desafio.ValidaTexto("Pedido realizado com sucesso!"));
        Base.Click(desafio.btnFechar);
    }

    @Test
    public void testDesafio02()
    {
        Base.Click(desafio.btnCategorias);
        Base.Click(desafio.btnCategoriasBebida);
        desafio.AdicionarTodosProdutos();
        Base.Click(desafio.btnCategorias);
        Base.Click(desafio.btnCategoriasTodos);
        Base.Click(desafio.btnAddProdutoRissole);
        Base.Click(desafio.btnCarrinho);
        desafio.MudarQuantidadeProduto(desafio.btnAumentarQtdeRissole,9);
        desafio.MudarQuantidadeProduto(desafio.btnDiminuirQtdeRissole,5);
        Assert.assertTrue(desafio.ValidaValor("R$ 36,00"));
        Base.Click(desafio.btnFinalizarCompra);
        Assert.assertTrue(desafio.ValidaTexto("Pedido realizado com sucesso!"));
        Base.Click(desafio.btnFechar);
    }
}
