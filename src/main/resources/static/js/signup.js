var formObject = new Vue({
    el : "#form_signup",
    data : {
        
    },
    methods: {
        validatePassword : function(event){
            if(inputTextPassword !== inputTextCpassword){
                validatePasswordMessage = "Password is not Matched"
            } else {
                validatePasswordMessage = ""
            }
        }
    }
})