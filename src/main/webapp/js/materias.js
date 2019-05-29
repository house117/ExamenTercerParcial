
Vue.component('examen', {
    template: `
    <div>
            <ul class="list-group" v-if="preguntas.length>0">
                    <li class="list-group-item" v-for="c in preguntas">{{c.pregunta}}
                    
                    
                    <ul>
                    <li class="list-group-item" v-for="d in c.respuestas">{{d}}</li>
                    </ul>
                    
                    </li>
                </ul>
    </div>
    
    `,
    props: ['preguntas'],
});

/*
<table class="table ml-2" >
                        <thead>
                            <tr>
                                <th>pregunta</th>
                            </tr>
                        </thead>
                        <tr v-for="c in preguntas">
                            <td>{{c.pregunta}}</td>
                        </tr>
                    </table>
*/

var app = new Vue({
    el: '#app',
    data: {
        materias: [],
        preguntas: [],
        vista: 'tabla'
    },
    mounted: function () {
        console.log('Iniciando componente my-categories');
        axios.get('/materia/findAll')
            .then(this.set_materias)
    },
    methods: {
        fn_categoria: function () {
            console.log("Estoy en materias");
        }, 
        set_materias: function(response){
            this.materias = response.data;
        },
        fn_examen: function(id){
            var fd = new FormData();
            fd.append("materia", id);
            console.log(id)
            axios.get('/materia/generarExamen/?materia='+id)
            .then(this.set_preguntas)
              this.vista = 'examen'
        },
        set_preguntas: function(response){
            console.log(response)
            this.preguntas = response.data;
            console.log(this.preguntas)
        }
    }
    
    
});