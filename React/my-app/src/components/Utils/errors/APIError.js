import { CustomError } from "./baseError";

export class NotFound extends CustomError{
    constructor(specificMessage){
        super(405, "Unauthorized", specificMessage);
    }
}

export class Unauthorized extends CustomError{
    constructor(specificMessage){
        super(405, "Unauthorized", specificMessage);
    }
}

export class Validation extends CustomError{
    constructor(specificMessage){
        super(405, "Unauthorized", specificMessage);
    }
}