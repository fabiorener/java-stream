package stream;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Exemplo {
	
	public static void main(String[] args) {
		
	      List<Venda> vendas = new ArrayList<Venda>() {{
	            add(new Venda(234, FormaPagamento.CARTAO));
	            add(new Venda(99.5, FormaPagamento.CARTAO));
	            add(new Venda(5674.98, FormaPagamento.DINHEIRO));
	            add(new Venda(76.9, FormaPagamento.CARTAO));
	        }};
	        
	        /*
	         * Usamos o m�todo stream() para obter uma inst�ncia da classe gen�rica Stream<T>. 
	         * Uma vez que nossa lista � composta por objetos do tipo Venda obtemos desse m�todo um Stream<Venda>, 
	         * a partir do qual podemos invocar alguns dos m�todos fundamentais presentes na Streams API.
	         */
	        
	        /*
	         * O m�todo filter() recebe um objeto do tipo Predicate, 
	         * como podemos ver em sua assinatura filter(Predicate<? super T> predicate). 
	         * 
	         * Predicate, por sua vez, � uma interface funcional que possui o m�todo abstrato test(T t). 
	         * 
	         * Podemos, portanto, usar uma Express�o Lambda para criar uma implementa��o para esse m�todo. 
	         * 
	         * No exemplo acima, test() receber� a forma de pagamento de cada venda na cole��o para comparar esse dado com a forma de pagamento cart�o. 
	         * 
	         * Por fim, se test() retornar true a venda atual poder� passar para o pr�ximo est�gio do fluxo, do contr�rio ela ser� ignorada.
	         */
	        
	        /*
	         * Agora que temos uma lista filtrada de vendas do tipo cart�o, 
	         * podemos orden�-la a partir de algum de seus atributos. 
	         * 
	         * Para isso usamos o m�todo sorted(), que recebe como par�metro um Comparator, que no Java 8 recebeu novos m�todos, 
	         * bem como o t�tulo de interface funcional. 
	         * 
	         * Para esse exemplo usamos a implementa��o dessa interface retornada pelo m�todo est�tico comparing(Function<? super T,? extends U> keyExtractor),
	         * usando como argumento o atributo da classe Venda atrav�s do qual desejamos ordenar a cole��o.
	         */
	 
	        /*
	         * Nesse contexto, mapear significa transformar um dado em outro. 
	         * 
	         * E � exatamente o que fazemos nessa linha,
	         * pois nesse ponto passamos adiante no fluxo o valor de cada objeto do tipo Venda da cole��o como um double.
	         */
	        
	        /*
	         * Ao final, com o m�todo forEach() exibimos o valor de cada venda, ap�s seu processamento.
	         * 
			 * � importante ressaltar que a Streams API n�o � composta apenas pela classe Stream.
			 * 
			 * Dentro dessa API temos outras classes para o processamento de fluxos diversos, incluindo arquivos.
	         */
	        vendas.stream()
	                .filter(v -> v.getFormaPagamento() == FormaPagamento.CARTAO)
	                .sorted(comparing(Venda::getTotal))
	                .map(Venda::getTotal)
	                .forEach(System.out::println);
	        
		
	}

}
