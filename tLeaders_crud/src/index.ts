import express, { Request, Response } from "express";
import { AppDataSource } from "./config/connection-db";
import teamLeaderRouter from "./router/Team-leader.route";
import { client } from "./config/eureka-client";

const app = express();
app.use(express.json());

// app.get("/", (req: Request, res: Response)=>{
//   res.json({message: "Hello world"});
// })

app.use("/api/v1/team-leader",teamLeaderRouter);

AppDataSource
        .initialize()
        .then(() =>{ 
            console.log("Data Source has been initialized!");   
            app.listen(7000, ()=>{
              console.log("Server running on port 7000");
              client.start(error =>{
                console.log(error || "Eureka Client started")
              })             

            })
          })
        .catch((err) => console.error("Error during Data Source initialization", err));
        