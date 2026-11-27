import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Terrain } from '../models/terrain.model';

@Injectable({ providedIn: 'root' })
export class TerrainService {
  private readonly apiUrl = '/api/terrains';

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Terrain[]> {
    return this.http.get<Terrain[]>(this.apiUrl);
  }

  getById(id: number): Observable<Terrain> {
    return this.http.get<Terrain>(`${this.apiUrl}/${id}`);
  }

  create(terrain: Omit<Terrain, 'identifiant'>): Observable<Terrain> {
    return this.http.post<Terrain>(this.apiUrl, terrain);
  }

  update(id: number, terrain: Omit<Terrain, 'identifiant'>): Observable<Terrain> {
    return this.http.put<Terrain>(`${this.apiUrl}/${id}`, terrain);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
