/**
 * Confirmar excluir
 * @author Lucas Costa
 */

function confirmar(){
	let excluir = document.querySelector("#excluir");
	if(confirm("Deseja realmente excluir o contato?")){
		document.forms['formContato'].submit();
	}else{
		excluir.setAttribute('href', 'main');
	}
}