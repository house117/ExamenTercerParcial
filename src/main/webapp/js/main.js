Vue.component('respuesta-component',{
    template:`
    <div class="resp_block">
        <div style="padding-left: 8px">
            <label for="resp">Respuesta</label><input type="text" size="40" v-bind:id="fn_name('resp',index,-1)" v-model:value="inputText" @keyup.enter="fn_add_resp">
            <input type="checkbox" v-model="checked">Respuesta correcta
            <input type="button" value="+" @click="fn_add_resp">
        </div>
        <ul v-if="preg.resps.length>0">
            <li v-for="(resp,idx) in preg.resps">
            {{resp.desc}} <input type="radio" v-bind:id="fn_name('_r',index,idx)" v-bind:name="fn_name('_r',index,-1)" v-bind:value="idx" :checked="resp.isTheRightAnswer" @change="fn_radio_change">{{resp.isTheRightAnswer}}
            </li>
        </ul>
    </div>
    `,
    data:function(){
        return {
            inputText:'',
            checked:true,
            picked:false
        }
    },
    methods:{
        fn_add_resp: function () {
            this.preg.resps.push({desc:this.inputText,isTheRightAnswer:this.checked}); //entramos al objeto preg -> luego a su obj resps,
            /*El objeto resps:
            * resps: {
            *   desc: "",
            *   isTheRightAnswer: boolean
            * }
            /* Hacemos push, dentro de resps, ponemos su descripción al valor de input text
            *   luego isTheRightAnswer
            */
            this.checked=false; //cambiamos el checbox a false para que se quite para la siguiente pregunta
            this.inputText='' //limpiamos el input de las respuestas
        },
        fn_name:function(pre,mid,pos){
            return pre+'_'+mid+(pos>=0?'_'+pos:'')
        },
        fn_radio_change:function(e){
            for(var i=0;i<this.preg.resps.length;i++){
                this.preg.resps[i].isTheRightAnswer= (i== e.target.value)
            }
        },
    },
    mounted: function () {
        document.getElementById("resp_"+this.index).focus();
    },
    props:['index','preg']
});

function fn_clean_prepare(inStr){
    return inStr.replace('¬', ' ').replace('·', '.').replace("\n",'').trim();
}
var app = new Vue({
    el: '#app',
    data: {
        pregs: [],
        current_preg:'',
        current_preg_mat:'',
        data:'',
        materias: null
    },
    mounted: function () {
        console.log('Iniciando componente my-categories');
        axios.get('/materia/findAll')
            .then(this.set_materias)
    },
    methods: {
        fn_add: function () {
            this.pregs.push({desc: this.current_preg,mat: this.current_preg_mat,resps:[]}); 
            /* Inserta una pregunta, el obj pregs tiene 2 parametros
            * desc, que es la descripcion de la pregunta, y resps, que son las respuestas de dicha pregunta
            */
            this.current_preg='' //limpia la entrada de texto de current preg
        },
        fn_remove_question:function(index)
        {
            console.log(index);
            this.pregs.splice(index,1) // El primer parámetro es el index, el segundo el número de items afectados a partir de ahí
            //si hubiera un tercer parámetro, se reemplazaría lo que hay en el index 1 por ese, como no hay, se elimina
        },
        set_materias: function(response){
            this.materias = response.data;
        }, 
        fn_ver:function(){
            var arr=[]; //obvio, se crea un array limpio
            for(var i=0;i<this.pregs.length;i++){ //recorremos pregs, recordemos lo que hay en pregs:
            /* pregs: {
            *   desc: "",
            *   resps: []
            *
            *
            */
                var index = -1;
                var resps=[];
                for(var j=0;j<this.pregs[i].resps.length;j++){
                    resps[j]=fn_clean_prepare(this.pregs[i].resps[j].desc);
                    if( this.pregs[i].resps[j].isTheRightAnswer) index=j;
                }
                arr.push(fn_clean_prepare(this.pregs[i].desc)+ '¬'+ this.pregs[i].mat + '¬'+ resps.join('·') + '¬' + index)
            }
            this.data=arr.join('\n');
            console.log(this.data);
            alert('Esto se mandaría al servidor\n\n'+this.data);
            var fd = new FormData();
            fd.append("data", this.data);
            axios({
                method:'post',
                url: 'materia/create',
                responseType: 'json',
                data: fd
            })
              .then(function (response) {
                //this.app.productos = response.data;
                console.log("FUNCIONÓ")
              })
        },
        fn_enviar: function () {
           
            
        }
    },
    computed:{
    }
});
