import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private http: HttpClient) { }

  private readonly XP = `${environment.XP}cadastro`

  upload(file: File) {
    const formData = new FormData();
    formData.append('file', file, file.name);
    this.cadastroFile(formData).subscribe(
      sucess => console.log('sucesso'),
      error => console.log('error'),
      () => console.log('request completo')
    );
  }

  public cadastroFile(file: FormData) {
    return this.http.post(this.XP+'/upload', file).pipe(take(1));
  }

}
