$(document).ready(() => {
    loadItem();

    $('#add').on('click', (ev) => {
        ev.preventDefault();
        const val = $('#in').val();
        const item = new Object();
        item.name = val;
        $.ajax({
            type: "post",
            url: "json",
            contentType: "json; charset=utf-8",
            data: JSON.stringify(item)
        }).done(() => {
            loadItem();
        })
    });

    $('#del').on('click', (ev) => {
        ev.preventDefault();
        const val = $('#in').val();
        const item = new Object();
        item.name = val;
        $.ajax({
            type: "post",
            url: "json",
            contentType: "json; charset=utf-8",
            data: JSON.stringify(item)
        }).done(() => {
            loadItem();
        })
    });

    $('#all').change(() => {
        loadItem();
    });

    $(document).on("change", "#ul > li > span > input[type=\"checkbox\"]", (ev) => {
        const id = $(ev.target).prop("id");
        const name = $(ev.target).parent().text().trim();
        const item = new Object();
        item.id = id;
        item.name = name;
        item.done = true;
        $.ajax({
            type: "post",
            url: "json",
            contentType: "json; charset=utf-8",
            data: JSON.stringify(item)
        }).done(() => {
            loadItem();
        })
    });

    function loadItem () {
        $.ajax({
            url: 'json',
            type: 'get',
            success: (data) => {
                const items = [];
                $("#ul").find('li').remove();

                $.each(data, (key, item) => {
                    const date = new Date(item.created);
                    const fdate = moment(date).format('YYYY-MM-DD HH:mm:ss');
                    const li = `<li class="list-group-item" >
                          <span className="todo-list-item-label"   ${item.done ? `id="done" ` : ``}  > 
                          <input  id=${item.id}    class="checkbox" type="checkbox"  ng-model="x.done"  ${item.done ? `checked ` : `` } > 
                               ${fdate}    |  ${item.name}
                          </span> 
                          </li> `;
                    if ($("#all").is(':checked')) {
                        items.push(li);
                    } else if (!item.done) {
                        items.push(li);
                    }
                });
                $('#ul').append(items.join(''));
            }
        });
    }
});
