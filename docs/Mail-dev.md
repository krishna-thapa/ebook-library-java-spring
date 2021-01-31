## MailDev

📫 SMTP Server + Web Interface for viewing and testing emails during development.
MailDev is a simple way to test your project's generated emails during development with an easy to use web interface that runs on your machine built on top of Node.js.

### [Github page](https://github.com/maildev/maildev)

### Npm Install
```
$ npm install -g maildev
$ maildev
```

### Docker-compose 
```
  maildev:
    image: maildev/maildev
    ports:
      - "1080:80"
```

Once it is running, go to: 
```http://localhost:1080/#/```