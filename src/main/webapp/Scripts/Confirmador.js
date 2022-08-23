/**
 * Confirmar exclusao
 * @author Lucas Costa
 * @param id int
 */

function confirmar(id){
	if(confirm("Deseja realmente excluir o contato?")){
		window.location.href = "delete?id=" + id;
	}
}