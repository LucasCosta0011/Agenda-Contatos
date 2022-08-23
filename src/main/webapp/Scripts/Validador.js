/**
 * Validação de formulário
 * @author Lucas Costa
 */

function validar(){
	formContato.tel.style.backgroundColor = "white";
	formContato.nome.style.backgroundColor = "white";
	let nome = formContato.nome.value;
	let tel = formContato.tel.value
	
	if(nome.trim() === ""){
		alert("Preencha o campo Nome!");
		formContato.nome.style.backgroundColor = "yellow";
		formContato.nome.focus();
		// para não submeter o form a camada controller
		return false;
	}else if(tel.trim() === ""){
		alert("Preencha o campo Telefone!");
		formContato.tel.style.backgroundColor = "yellow";
		formContato.tel.focus();
		return false;
	}else{
		
		// Envia o formulário para a camada controller
		document.forms["formContato"].submit();
	}
}