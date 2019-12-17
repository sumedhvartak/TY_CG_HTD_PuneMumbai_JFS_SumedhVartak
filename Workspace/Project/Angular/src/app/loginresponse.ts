export class Loginresponse {
    constructor(
        public idToken: string,
        public email: string,
        public refreshToken: string,
        public expiresIn: string,
        public registered: boolean
    ) {}
}
