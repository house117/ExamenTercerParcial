Vue.component('my-hello', {
    template: `
    <table class="table ml-2" v-if="vista=='examen'">
    <thead>
        <tr>
            <th>pregunta</th>

        </tr>

    </thead>
    <tr v-for="c in preguntas">
        <td>{{c.pregunta}}</td>
    </tr>
</table>    `
});

Vue.component('my-categories', {
    template: `
    <div>
    <h2>Nueva Categoria</h2>

		<form name="cat-form" action="/categoria/create" method="POST">
			<div class="form-group">
				<label>Nombre: </label><input type="text" name="nombre" class="form-control"><br>
				<button type="button" class="btn btn-warning" @click="fn_enviar">Enviar</button>
			</div>
		</form>
		<h3>Lista de categorías</h3>
		<ul class="list-group" v-if="categoria.length>0">
			<li class="list-group-item" v-for="c in categoria">{{c.id}} {{c.nombre}}</li>
		</ul>
		<div class="alert alert-danger" role="alert" v-else>
			Aún no hay categorías  capturadas
          </div>
          </div>
    `,
    props: ['categoria'],
    mounted: function () {
        console.log('Iniciando componente my-categories');
        axios.get('/categoria/read')
            .then(function (response) {
                // handle success
                this.app.categoria = response.data;
            })
    }, //Tarea: que se actualice 
    methods: {
        fn_enviar: function () {
            var fd = new FormData();
            fd.append("nombre", document.forms['cat-form'].nombre.value);
            axios({
                method:'post',
                url: 'categoria/create',
                responseType: 'json',
                data: fd
            })
            .then(function (response) {
                this.app.categoria = response.data;
              })
        }
    }
})

Vue.component('my-products', {
    template: `
    <div>
    <h2>Nuevo Producto</h2>
		<form name="cat-form" action="/producto/create" method="POST">
			<div class="form-group">
                <label>Nombre: </label><input type="text" name="nombre" class="form-control"><br>
                <select class="browser-default custom-select" name="categoria">
                    <option v-for="c in categoria">
                    {{ c.nombre }}
                    </option>
                    </select><br><br>
                <button type="button" class="btn btn-warning" @click="fn_enviar">Enviar</button>
			</div>
		</form>
		<h3>Lista de productos</h3>
		<ul class="list-group" v-if="productos.length>0">
			<li class="list-group-item" v-for="producto in productos">{{producto.id}} {{producto.nombre}} {{producto.idcategoria}}</li>
		</ul>
		<div class="alert alert-danger" role="alert" v-else>
			Aún no hay productos  capturadoss
          </div>
          </div>
    `,
    props: ['categoria','productos'],
    mounted: function () {
        console.log('Iniciando componente my-categories');
        axios.get('/producto/read')
            .then(function (response) {
                // handle success
                this.app.productos = response.data;
            })
            axios.get('/categoria/read')
            .then(function (response) {
                // handle success
                this.app.categoria = response.data;
            })
    }, //Tarea: que se actualice 
    methods: {
        fn_enviar: function () {
            var fd = new FormData();
            fd.append("nombre", document.forms['cat-form'].nombre.value);
            fd.append("categoria", document.forms['cat-form'].categoria.value);
            axios({
                method:'post',
                url: 'producto/create',
                responseType: 'json',
                data: fd
            })
              .then(function (response) {
                this.app.productos = response.data;
              })
        }
    }
})

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        categoria: [{
            id: 1,
            nombre: 'Cosmeticos'
        }, {
            id: 2,
            nombre: 'Alimentos'
        }],
        opcion: 'categoria',
        productos:[]
    },
    methods: {
        fn_categoria: function () {
            console.log("Estoy en categoría");

        },
        
    }
})