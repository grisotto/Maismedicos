var gulp = require('gulp');






// Copy vendor libraries from /templatefsw into /assets
gulp.task('copy', function() {

gulp.src([
    	'src/main/webapp/WEB-INF/assets/templatefsw/bootstrap/**/*'])
		.pipe(gulp.dest('src/main/webapp/WEB-INF/assets/bootstrap'));

gulp.src([
	'src/main/webapp/WEB-INF/assets/templatefsw/dist/**/*'])
		.pipe(gulp.dest('src/main/webapp/WEB-INF/assets/dist'));

gulp.src([
	'src/main/webapp/WEB-INF/assets/templatefsw/plugins/**/*'])
		.pipe(gulp.dest('src/main/webapp/WEB-INF/assets/plugins'));
})

// Run everything
gulp.task('default', ['copy']);

// Configure the browserSync task
gulp.task('browserSync', function() {
    browserSync.init({
        server: {
            baseDir: ''
        },
    })
})


