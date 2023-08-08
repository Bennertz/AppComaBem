package sp.senai;

import junit.framework.TestCase;

public class CadastroActivityTest extends TestCase {
    public void testInserir() {
        CadastroActivity c = new CadastroActivity();

        String produtoNome = "Produto 1";
        double produtoQuantidade = 10;
        double produtoPreco = 5.50;

        Produto produto = new Produto(produtoNome, produtoQuantidade, produtoPreco);

        assertEquals("Produto 1", c.inserir(produto));
    }
}
