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
	         * Usamos o método stream() para obter uma instância da classe genérica Stream<T>. 
	         * Uma vez que nossa lista é composta por objetos do tipo Venda obtemos desse método um Stream<Venda>, 
	         * a partir do qual podemos invocar alguns dos métodos fundamentais presentes na Streams API.
	         */
	        
	        /*
	         * O método filter() recebe um objeto do tipo Predicate, 
	         * como podemos ver em sua assinatura filter(Predicate<? super T> predicate). 
	         * 
	         * Predicate, por sua vez, é uma interface funcional que possui o método abstrato test(T t). 
	         * 
	         * Podemos, portanto, usar uma Expressão Lambda para criar uma implementação para esse método. 
	         * 
	         * No exemplo acima, test() receberá a forma de pagamento de cada venda na coleção para comparar esse dado com a forma de pagamento cartão. 
	         * 
	         * Por fim, se test() retornar true a venda atual poderá passar para o próximo estágio do fluxo, do contrário ela será ignorada.
	         */
	        
	        /*
	         * Agora que temos uma lista filtrada de vendas do tipo cartão, 
	         * podemos ordená-la a partir de algum de seus atributos. 
	         * 
	         * Para isso usamos o método sorted(), que recebe como parâmetro um Comparator, que no Java 8 recebeu novos métodos, 
	         * bem como o título de interface funcional. 
	         * 
	         * Para esse exemplo usamos a implementação dessa interface retornada pelo método estático comparing(Function<? super T,? extends U> keyExtractor),
	         * usando como argumento o atributo da classe Venda através do qual desejamos ordenar a coleção.
	         */
	 
	        /*
	         * Nesse contexto, mapear significa transformar um dado em outro. 
	         * 
	         * E é exatamente o que fazemos nessa linha,
	         * pois nesse ponto passamos adiante no fluxo o valor de cada objeto do tipo Venda da coleção como um double.
	         */
	        
	        /*
	         * Ao final, com o método forEach() exibimos o valor de cada venda, após seu processamento.
	         * 
			 * É importante ressaltar que a Streams API não é composta apenas pela classe Stream.
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
