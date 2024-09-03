# Use an official Node.js image as a parent image
FROM node:19.9-alpine

# Set the working directory in the container
WORKDIR /app/frontend

# Copy the package.json and package-lock.json files
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the project source code to the working directory in the container
COPY . .

# Run the Node.js application
CMD ["npm", "start"]