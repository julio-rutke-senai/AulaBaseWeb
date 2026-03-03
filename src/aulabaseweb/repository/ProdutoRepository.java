package aulabaseweb.repository;

import aulabaseweb.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList();

    public ProdutoRepository(){
        criarProduto(new Produto(1, "Teclado", 50.0f));
        criarProduto(new Produto(2, "Mouse", 150.0f));
        criarProduto(new Produto(3, "Monitor", 1500.0f));
        criarProduto(new Produto(4, "Processador", 950.0f));
        criarProduto(new Produto(5, "Memoria", 500.0f));
    }

    public void criarProduto(Produto produto){
        produtos.add(produto);
    }

    public List<Produto> buscarProdutos(){
        return produtos;
    }


}
