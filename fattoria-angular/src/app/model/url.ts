export class url{

    idURL: number;

    originalURL: string;

    shortURL: string;

    constructor(idURL?:number, originalURL?:string, shortURL?:string){
        this.idURL=idURL;
        this.originalURL=originalURL;
        this.shortURL=shortURL;
    }
}