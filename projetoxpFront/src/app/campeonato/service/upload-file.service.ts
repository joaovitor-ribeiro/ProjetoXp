import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private http: HttpClient) { }

  private readonly XP = `${environment.XP}upload`

  upload(file: File, local: string) {
    const formData = new FormData();
    formData.append('file', file, file.name);
    this.cadastroFile(formData, local).subscribe(
      sucess => console.log('sucesso'),
      error => console.log(error),
      () => console.log('request completo')
    );
  }

  public cadastroFile(file: FormData, local: string) {
    return this.http.post(this.XP+`/${local}`, file).pipe(take(1));
  }

}
