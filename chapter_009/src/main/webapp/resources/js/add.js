$(document).ready(() => {

    $.ajax({
        url: '/emp/part',
        type: 'get',
        success: (data) => {
            console.log('TT', data);
            $.each(data, (key, value) => {
                apply(value, key);
            });
        }

    });

    $('#add').on('click', (ev) => {
        ev.preventDefault();
        const car = new Object();
        const engineType = new Object();
        engineType.id = $('#engineType').find("option:selected").attr("id");
        const engineVolum = new Object();
        engineVolum.id = $('#engineVolum').find("option:selected").attr("id");
        const carCategory = new Object();
        carCategory.id = $('#category').find("option:selected").attr("id");
        const transmission = new Object();
        transmission.id = $('#gearbox').find("option:selected").attr("id");
        const markCar = new Object();
        markCar.id = $('#mark').find("option:selected").attr("id");
        const carModel = new Object();
        carModel.id = $('#model').find("option:selected").attr("id");
        const carBody = new Object();
        carBody.id = $('#body').find("option:selected").attr("id");
        const year = new Object();
        year.id = $('#year').find("option:selected").attr("id");
        const colour = new Object();
        colour.id = $('#colour').find("option:selected").attr("id");

        car.mileage = $('#mileage').val();
        car.price = $('#price').val();
        car.markCar = markCar;
        car.carBody = carBody;
        car.colour = colour;
        car.engineType = engineType;
        car.engineVolum = engineVolum;
        car.carCategory = carCategory;
        car.carModel = carModel;
        car.transmission = transmission;
        car.year = year;


        $.ajax({
            type: "post",
            contentType:"application/json",
            url: "/emp/add",
            dataType: "json",
            data: JSON.stringify(car)
        })
    });


    const apply = (value, key) => {
        let opt = '';

        value.forEach((el) => {
            opt += '<option ' + 'id=' + el.id + ' >' + el.name + '</option>';
        });
        const id = '#' + key;
        $(id).append(opt);
    };


    $('#upload').on('click', (e) => {
        e.preventDefault();
        const fd = new FormData();
        $.each($('#fileUpload')[0].files, function(k, value)
        {
            fd.append(k, value);
        });

        $.ajax({
            url: '/load',
            data: fd,
            processData: false,
            contentType: false,
            type: 'post',
            success: function(result) {
                $('#output').append(result);
            }
        });
    });


        $(document).on("change", "#mark", (ev) => {
        const optionText = $("#mark option:selected").text().trim();
        const url = "model?mark=" + optionText;
        $.ajax({
            url: url,
            type: 'get',
            success: (data) => {
                let opt = '';
                $("#model").find('option').remove();
                $.each(data, (key, value) => {
                    opt += '<option ' + 'id=' + value.id + ' >' + value.name + '</option>';
                });
                $('#model').prop('disabled', false);
                $('#model').append(opt);
            }
        });
    });


    $('.custom-file-input').on('change', function () {
        let fileName = $(this).val().split('\\').pop();
        $(this).next('.custom-file-label').addClass("selected").html(fileName);
    });
});

