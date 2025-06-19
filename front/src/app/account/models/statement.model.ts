import {Transaction} from "./transaction.model";

export interface Statement {
  balance: number
  transactions: Transaction[]
}
