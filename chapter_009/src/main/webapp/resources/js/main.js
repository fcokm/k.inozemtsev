$(document).ready(() => {
    $.ajax({
        url: '/emp/all',
        type: 'get',
        encoding: 'UTF-8',
        success: (data) => {
            console.log(data);
            $('#au').find(' .auto.jumbotron.rounded').remove();
            $('#au').append(app(data).join(''));
        }
    }).done(() => {
        loadModel();
    });


    function loadModel() {
        $.ajax({
            url: '/emp/allmark',
            type: 'get',
            success: (data) => {
                let opt = '';
                $.each(data, (key, value) => {
                    opt += '<option ' + 'id=' + value.id + ' >' + value.name + '</option>';
                });
                $('#mark').append(opt);
            }
        });

    };


    $('#mark').change(() => {
        const optionText = $("#mark option:selected").text().trim();
        $.ajax({
            url: '/emp/cars?data=mark&mark_name='  + optionText,
            type: 'get',
            success: (data) => {
                $('#au').find('.auto.jumbotron.rounded').remove();
                $('#au').append(app(data).join(''));
            }
        })
    });


    const app = (data) => {
        let items = [];
        let opt = '';
        $.each(data, (key, value) => {
            console.log('sk', value);
            value.forEach((el) => {
                const ids = el.id;
                opt += '<div class="auto jumbotron rounded">'
                    + ' <img class="auto-image" src=\"data:image\/png;base64,' + el.base64DataString + '\">'
                    + '<ul class="list-group list-group-flush"> '
                    + '<li class="list-group-item"><span class="term">Status: </span><span>' + el.status + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Mark: </span><span>' + el.markCar.name + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Model: </span><span>' + el.carModel.name + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Engine type: </span><span>' + el.engineType.name + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Engine volume: </span><span>' + el.engineVolum.name + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Colour: </span><span>' + el.colour.name + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Year: </span><span>' + el.year.name + '</span></li> '
                    + '<li class="list-group-item"><span class="term">Milearge: </span><span>' + el.mileage + '</span></li>'
                    + '<li class="list-group-item"><span class="term">Price: </span><span>' + el.price + '</span></li>'
                if (key == el.user.id) {
                    opt += '<li class="list-group-item"><span class="term"></span>'
                        + '<select class="selectpicker" id=' + ids +'>'
                        + '<option data-hidden="true">Status</option>'
                        + '<option id="1" value="isForSale">isForSale</option>'
                        + '<option id="2" value="sales">sales</option>'
                        + '</select>'
                        + '</li>'
                        + '  </ul>'
                        + '</div>'

                } else {
                    opt += ' </ul>'
                        + '</div>'
                }

            });

        });
        items.push(opt);
        return items;
    };


    $('#cd').change(function () {
        let url = '/emp/cars?data=';
        url += $(this).prop('checked') ? 'last' : 'all';
        $.ajax({
            url: url,
            type: 'get',
            success: (data) => {
                $('#au').find('.auto.jumbotron.rounded').remove();
                $('#au').append(app(data).join(''));

            }
        });

    });


    $(document).on("change", "#au > .auto.jumbotron.rounded > ul > li > select ", (ev) => {
        const id = $(ev.target).prop("id");
        const optVal = $(".selectpicker option:selected").val().trim();
        const st = optVal == 'sales' ? 'SALES' : 'IS_FORSALE';
        const car = new Object();
        car.id = id;
        car.status = st;
        $.ajax({
            type: "post",
            url: "/",
            contentType: "json; charset=utf-8",
            data: JSON.stringify(car)
        })


    });

    $('#cf').change(function ()  {
        let url = '/emp/cars?data=';
        url += $(this).prop('checked') ? 'photo' : 'all';
        $.ajax({
            url: url,
            type: 'get',
            success: (data) => {
                $('#au').find('.auto.jumbotron.rounded').remove();
                $('#au').append(app(data).join(''));
            }
        });

    });

});


