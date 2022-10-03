 const form=document.getElementById("signUp");
    var email=document.getElementById("email");

    form.addEventListener('submit',e=>{
        e,preventDefault();
        check();
    });
    function check()
    {
        const emailvalue=email.ariaValueMax.trim();

        if(emailvalue ==='')
        {
            alert("email can not be blank");
        }
        else if(!emailvalue.match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/))
        {
            alert("invalid email");
        }
    }

 
 