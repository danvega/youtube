import {IncomingMessage, ServerResponse} from 'http';

export default(req:IncomingMessage, res:ServerResponse) => {
  return new Date().toLocaleTimeString();
}
