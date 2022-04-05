import { Injectable } from '@angular/core';
import { TareaPendiente } from './tarea-pendiente';

@Injectable({
  providedIn: 'root'
})
export class TareasService {
  CLAVE_LOCAL_STORAGE = "tareas_angular"

  constructor() { }

  obtenerTarea(): TareaPendiente[] {
    return JSON.parse(localStorage.getItem(this.CLAVE_LOCAL_STORAGE) || "[]")
  }
  guardarTarea(tareas: TareaPendiente[]) {
    localStorage.setItem(this.CLAVE_LOCAL_STORAGE, JSON.stringify(tareas))
  }
}