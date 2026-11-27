import { Coordonnees } from './coordonnees.model';

export interface Terrain {
  identifiant?: number;
  capacite: number;
  nom: string;
  coordonnees: Coordonnees;
}