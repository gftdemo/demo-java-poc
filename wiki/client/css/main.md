Português

```markdown
# Documentação de Código CSS

Este arquivo CSS define vários estilos para elementos HTML em um projeto de software. 

## Código

```css
body {
  padding-top: 5rem;
}
```
Este bloco de código adiciona um padding de 5rem ao topo do corpo do documento HTML.

```css
.puppy {
  padding: 3rem 1.5rem;
  text-align: center;
}
```
A classe `.puppy` adiciona um padding de 3rem na parte superior e inferior e 1.5rem à esquerda e à direita. Além disso, alinha o texto ao centro.

```css
.delete-comment {
  float: right;
  border-radius: 5px;
  padding: 3px 9px 3px 9px;
}
```
A classe `.delete-comment` faz o elemento flutuar à direita, dá ao elemento um raio de borda de 5px e adiciona padding de 3px na parte superior e inferior e 9px à esquerda e à direita.

```css
.delete-comment:hover {
  cursor: pointer;
  background-color: red;
}
```
Isso adiciona um efeito de hover à classe `.delete-comment`. Quando o mouse é colocado sobre o elemento, o cursor muda para um ponteiro e a cor de fundo do elemento muda para vermelho.

```css
.form-control.top {
  border-radius: .5em .5em 0 0
}
```
A classe `.form-control.top` arredonda as bordas superiores do elemento.

```css
.form-control.bottom {
  border-radius: 0 0 .5em .5em
}
```
A classe `.form-control.bottom` arredonda as bordas inferiores do elemento.

```css
.btn-block {
  margin-top: 10px;
}
```
A classe `.btn-block` adiciona uma margem superior de 10px ao botão.

```css
#signout {
  display: block;
  height: 32px;
  width: 32px;
  background-size:cover;
  position:absolute;
  right: 40px;
  top: 20px;
  background:url('../images/signout.png');
}
```
O id `#signout` define o elemento com um tamanho de 32x32px, posiciona-o absolutamente no topo e à direita do seu elemento pai e define uma imagem de fundo.

```css
#signout:hover {
  cursor: pointer;
  background:url('../images/signout-hover.png');
}
```
Este código adiciona um efeito de hover ao id `#signout`. Quando o mouse é colocado sobre o elemento, o cursor muda para um ponteiro e a imagem de fundo do elemento muda.
```