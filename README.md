# MediaProject-Unifil
<br>

# Facilidades que a Orientação a Objetos trouxe para o meu projeto

## Classe Abstrata
<p>Eu decidi utilizar uma classe abtrata pela facilidade e por conta do reaproveitamento de código. Já que os meus outros dois objetos vão ser extendidos por essa classe abstrata e poderão, por meio do polimorfismo, utlizar as propriedade dessa classe.</p>
<img src="https://github.com/raquel-cmps/MediaProject-Unifil/blob/main/images/abstractClass.jpg">
<p>Classe abstrata Media.</p>

<br>
<img src="https://github.com/raquel-cmps/MediaProject-Unifil/blob/main/images/movieClass.jpg">
<p>Classe concreta Movie que extende de Media.</p>

<br>
<img src="https://github.com/raquel-cmps/MediaProject-Unifil/blob/main/images/seriesClass.jpg">
<p>Classe concreta Series que extende de Media.</p>
<br>

## Interface
<p>No caso da interface, eu decidi utiliza-la para deixar o meu escopo do crud bem definido. Assim eu posso implentar essa interface nas camadas de serviço que irão realizar o crud e eu vou ter a certeza que, obrigatoriamente, precisarão implementar os métodos abstratos contidos na minha interface.</p>
<img src="https://github.com/raquel-cmps/MediaProject-Unifil/blob/main/images/interface.jpg">
<p>Interface Crud que contém as assinaturas dos métodos que serão usados no crud dos objetos.</p>

<br>
<img src="https://github.com/raquel-cmps/MediaProject-Unifil/blob/main/images/implementsInterface.jpg">
<p>Exemplo da utilização da interface na minha classe concreta de serviço.</p>
