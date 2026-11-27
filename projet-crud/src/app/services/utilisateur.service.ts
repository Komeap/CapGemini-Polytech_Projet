import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({ providedIn: 'root' })
export class UtilisateurService {
  private readonly apiUrl = '/api/utilisateurs';

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  getById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  create(utilisateur: Omit<User, 'identifiant'>): Observable<User> {
    return this.http.post<User>(this.apiUrl, utilisateur);
  }

  update(id: number, utilisateur: Omit<User, 'identifiant'>): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/${id}`, utilisateur);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
