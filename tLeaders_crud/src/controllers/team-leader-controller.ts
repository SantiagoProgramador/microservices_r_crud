import { Request, Response } from "express";
import { AppDataSource } from "../config/connection-db";
import { TeamLeader } from "../entities/Team-leader";


const teamLeaderRepository = AppDataSource.getRepository(TeamLeader);

export function getAll(request:Request,response:Response){
  // teamLeaderRepository.find()
  // .then((teamLeaders) => {
  //   response.json(teamLeaders);
  //   })
  // .catch((error) => {
  //     response.status(500).json({message: error.message});
  //     });
    try{
      response.json({
        data: teamLeaderRepository.find()
      })
    } catch (error){
        response.json({
          message: error.message
        })
    }
}