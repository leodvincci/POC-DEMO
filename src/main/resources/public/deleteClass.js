function deletetheuser(){
    console.log("Running")
    let dpt = parseFloat(document.getElementById('department').value);
	let cnm = parseFloat(document.getElementById('classNumber').value);
    console.log(id + " Was Deleted")
   fetch('http://localhost:8080/api/v1/searchandremoveclass?department=' + dpt + '&classNumber=' + cnm, {
       method: 'DELETE'
   }).then(r  =>(alert(dpt + " " + cnm + " Was Deleted")))
}