# JobApp

## Overview

JobApp is an Android application that allows users to search for jobs, view job details, and bookmark jobs for later reference. The app fetches job data from an API and displays it in a list with infinite scrolling. Users can bookmark jobs and view them offline in a separate "Bookmarks" section. Clicking on a job opens a detailed view of the job information.

## Features

- **Job Search**: Search for jobs and view job details.
- **Infinite Scrolling**: Load more jobs as you scroll.
- **Bookmark Jobs**: Save jobs to view later.
- **Offline Viewing**: View bookmarked jobs offline.
- **Job Details**: View detailed information about each job.
- **Delete Bookmarked Jobs**: Remove jobs from the bookmarks list.

## Technologies Used

- **Android Studio**: Development environment.
- **Java**: Programming language.
- **Retrofit**: For API calls.
- **Room**: For local database management.
- **RecyclerView**: For displaying job data.
- **Glide**: For loading images in the detailed view.
- **ConstraintLayout**: For designing the UI.

## Screenshots

![image](https://github.com/user-attachments/assets/94ec4965-8a62-4f5c-a2b7-db4f0ed339d9)
![image](https://github.com/user-attachments/assets/b9c8d1f1-96c8-4269-943f-93ebe481c393)
![image](https://github.com/user-attachments/assets/5047052e-1cb1-449e-b95d-51b4572f9350)
![image](https://github.com/user-attachments/assets/bbf65f85-6b57-4b44-9f72-d6dc5162cbe6)

## Video

https://github.com/user-attachments/assets/8bc25360-059b-493b-9801-dd2edf010ee2


## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/YOUR_USERNAME/JobApp.git
    ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Build and run the app on an emulator or physical device.

## Usage

1. **Search for Jobs**: Open the app and browse through the job listings. Scroll to load more jobs.
2. **Bookmark a Job**: Click the bookmark button on a job card to save it.
3. **View Bookmarked Jobs**: Navigate to the "Bookmarks" section to view saved jobs.
4. **View Job Details**: Click on a job card to view detailed information.
5. **Delete Bookmarked Jobs**: Click the delete button on a bookmarked job card to remove it.

## Code Structure

- **MainActivity.java**: Handles the main job search interface.
- **DetailActivity.java**: Displays detailed information about a job.
- **JobAdapter.java**: RecyclerView adapter for displaying job cards.
- **Job.java**: Model class for job data.
- **JobEntity.java**: Model class for bookmarked jobs.
- **AppDatabase.java**: Room database setup.
- **APIInterface.java**: Interface for Retrofit API calls.

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Retrofit](https://square.github.io/retrofit/)
- [Room](https://developer.android.com/training/data-storage/room)
- [Glide](https://github.com/bumptech/glide)

## Contact

- **Author**: Yash Bhagia
- **Email**: [yashbhagia9@gmail.com](mailto:yashbhagia9@gamil.com)

