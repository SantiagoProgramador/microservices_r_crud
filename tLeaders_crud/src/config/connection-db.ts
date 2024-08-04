import { DataSource } from "typeorm";
import * as mysql2 from "mysql2";




export const AppDataSource = new DataSource({
  type: "mysql",
  host: "localhost",
  port: 3307,
  username: "root",
  password: "root",
  database: "riwi_clanCrud_DB",
  synchronize: true,
  entities: ["src/entities/**/*.ts"],
  driver: mysql2
});