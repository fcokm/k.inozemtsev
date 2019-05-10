
$(document).ready(function () {
    $.ajax({
        url: 'json',
        type: 'get',
        success: function (data) {
            var optCountry = '';
            var optCity = '';
            $.each(data, function (key, value) {
                console.log(key);
                optCountry += '<option>' + key + '</option>';
                optCity += '<option>' + value[0] + '</option>';
            });

            $('#country').append(optCountry);
            $('#city').append(optCity);
        }
    });

    $('#country').change(function () {
        var selectedValue = $(this).val();

        $.ajax({
            url: 'json',
            type: "post",
            data: {country: selectedValue}
        }).done(function (data) {
            $('#city').html(data)
        });
    });


    $('#sub').click(function(event) {
        if(validate() === false) {
            event.preventDefault();
            return false;
        }
    });

});

function validName(name) {

    if (name.val().trim() == "") {
        $('#valid').html(" <label  class=\"control-label\">Fill in the name  field </label>");
        return false;
    }
    if (/^[A-Za-z ]+$/.test(name.val()) == false) {
        console.log(/^[A-Za-z ]+$/.test(name.val()))

        $('#valid').html(" <label  class=\"control-label\">Field NAME  " +
            " contain only characters</label>");
        return false;
    }
    return true;
}

function validEmail(email) {
    if (email.val().trim() == "") {
        $('#valid').html(" <label  class=\"control-label\">Fill in  the EMAIL field </label>");
        return false;
    }
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (reg.test(email.val()) == false) {
        $('#valid').html(" <label  class=\"control-label\"> Enter the " +
            "correct e-mail</label>");
        return false;
    }
    return true;
}

function validate() {
    var arr = [$("#name"), $("#login"), $("#email"), $("#password")];
       if (validName(arr[0])=== false) {
           return false;
       }
      if (!validEmail(arr[2])=== false) {
         return false;
      }
      return true;
}



