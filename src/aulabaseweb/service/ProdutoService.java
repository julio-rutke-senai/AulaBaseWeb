package aulabaseweb.service;

import aulabaseweb.model.Produto;
import aulabaseweb.repository.ProdutoRepository;

public class ProdutoService {

    ProdutoRepository produtoRepository = new ProdutoRepository();

    public StringBuilder buscarProdutos(){
        StringBuilder bodyResponse = new StringBuilder("{");
        bodyResponse.append("\"status\": \"OK\",\n");
        bodyResponse.append("\"message\": \"Servidor funcionando!\",\n");
        bodyResponse.append("\"produtos\": [\n");

        produtoRepository.buscarProdutos().stream().forEach(produto -> {
            bodyResponse.append("{\n");
            bodyResponse.append("\"codigo\": "+produto.getCodigo()+",\n");
            bodyResponse.append("\"descricao\": "+produto.getDescricao()+",\n");
            bodyResponse.append("\"preco\": "+produto.getPreco()+"\n");
            bodyResponse.append("}\n");
        });

        bodyResponse.append("]\n");
        bodyResponse.append("}");

        return bodyResponse;
    }

    public StringBuilder adicionarProduto() {

        Produto produto = new Produto();
        produto.setCodigo(28);
        produto.setPreco(25);
        produto.setDescricao("Bateria");

        produtoRepository.criarProduto(produto);

        StringBuilder response = new StringBuilder("Produto Adicionado com Sucesso!");

        return response;
    }
}
