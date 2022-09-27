function deletetheuser(){
    console.log("Running")
    let id = parseFloat(document.getElementById('id').value);
    console.log(id + " Was Deleted")
   fetch('http://3.88.60.54:8080/removeuser?id=' + id, {
       method: 'DELETE'
   }).then(r  =>(alert(id + " was deleted")))
}


    
