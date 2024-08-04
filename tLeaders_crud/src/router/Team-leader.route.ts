import { Router } from "express";
import { getAll } from "../controllers/team-leader-controller";

const teamLeaderRouter = Router();

teamLeaderRouter.get("/", getAll);

export default teamLeaderRouter;