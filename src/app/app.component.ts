import { Component, OnInit } from '@angular/core';
import { TareaPendiente } from './tarea-pendiente';
import { TareasService } from './tarea.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  
  constructor(private tareasService: TareasService){}
    
    nombreTarea = ""
    public tareas: TareaPendiente[] = []

  guardarTarea(){
    const nuevaTarea = new TareaPendiente(this.nombreTarea) // se instancia un objeto nuevaTarea de la clase de TareaPendiente
    this.tareas.push(nuevaTarea) // se agrega a la lista
    this.tareasService.guardarTarea(this.tareas) // se guarda en el localSotarge
    this.obtenerTarea()

    this.nombreTarea = "" // se inicializa el nombre de la tarea vacio
  }

  eliminarTarea(indice: number) {
    // Primero le preguntamos al usuario
    const confirma = confirm("¿Realmente quiere eliminar la tarea?");
    if (!confirma) {
      return;
    }
    // Elimino la tarea del arreglo y se guarda en localStorage
    this.tareas.splice(indice, 1);
    this.tareasService.guardarTarea(this.tareas);
  }

  cambiarEstadoDeTarea() {
    this.tareasService.guardarTarea(this.tareas);
    // Tambien se guarda cuando se la tacha al haberla completado
  }

  obtenerTarea() {
    this.tareas = this.tareasService.obtenerTarea(); // se obtiene la tarea almacenada en el localStorage
  }
  ngOnInit() {
    this.obtenerTarea();
  }


}
