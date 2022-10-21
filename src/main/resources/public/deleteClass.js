function deletetheclass(){
    console.log("Running")
    let className = parseFloat(document.getElementById('className').value);
    console.log(className + " Was Deleted")
   fetch('http://3.88.60.54:8080/removeclass?className=' + className, {
       method: 'DELETE'
   }).then(r  =>(alert(className + " was deleted")))
}